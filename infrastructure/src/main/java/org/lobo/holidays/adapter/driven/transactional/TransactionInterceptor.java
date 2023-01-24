package org.lobo.holidays.adapter.driven.transactional;

import lombok.AllArgsConstructor;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.reactivestreams.Publisher;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The type Transaction interceptor.
 * 
 * @author joseluis.anton
 */
@AllArgsConstructor
public class TransactionInterceptor implements MethodInterceptor {

  private TransactionalOperator transactionalOperator;

  /**
   * {@inheritDoc}
   */
  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {

    Object result=null;
    if(UseCaseHelper.isUseCasePresentInType(invocation.getThis())
        //checking UseCase annotation in invocation object class
        ||UseCaseHelper.isUseCasePresentInMethod(invocation.getThis().getClass().getMethod(invocation.getMethod().getName(),invocation.getMethod().getParameterTypes()))
        //checking UseCase annotation in invocation interface
        ||UseCaseHelper.isUseCasePresentInMethod(invocation.getMethod())){
      result=executeInTransaction(invocation);
    }else {
      result=invocation.proceed();
    }
    return result;


  }

  private Object executeInTransaction(MethodInvocation invocation) throws Throwable {
    Class returnType=invocation.getMethod().getReturnType();
    Publisher<Object> result=null;
    if(returnType.equals(Mono.class)){
      result=((Mono<Object>)invocation.proceed()).as(transactionalOperator::transactional);
    }else if(returnType.equals(Flux.class)){
      result=((Flux<Object>)invocation.proceed()).as(transactionalOperator::transactional);
    }else {
      result=Flux.just(invocation.proceed()).as(transactionalOperator::transactional);
    }

   return result;
  }
}
