package org.lobo.holidays.adapter.driving.transactional;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.reactivestreams.Publisher;
import org.springframework.transaction.ReactiveTransaction;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.reactive.TransactionCallback;
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
    if(UseCaseHelper.isUseCasePresentInType(invocation.getThis())||UseCaseHelper.isUseCasePresentInMethod(invocation.getMethod())){
      result=executeInTransaction(invocation);
    }else {
      result=invocation.proceed();
    }
    return result;


  }

  private Object executeInTransaction(MethodInvocation invocation) {
    return transactionalOperator.execute(new TransactionCallback<>() {
      @Override
      public Publisher<Object> doInTransaction(ReactiveTransaction status) {
        try {
          return (Publisher<Object>) invocation.proceed();
        } catch (Throwable e) {
          return Mono.error(e);
        }
      }
    });
  }
}
