package org.lobo.holidays.adapter.driving.transactional;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.reactive.TransactionalOperator;

/**
 * The type Transactional bean post processor.
 * 
 * @author joseluis.anton
 */
@Component
public class TransactionalBeanPostProcessor implements BeanPostProcessor {
  @Autowired
  private ReactiveTransactionManager transactionManager;
  /**
   * {@inheritDoc}
   */
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

    Object result = bean;
    
     if(UseCaseHelper.isUseCase(bean)){
      ProxyFactory proxyFactory = new ProxyFactory(bean);
      proxyFactory.addAdvice(new TransactionInterceptor(TransactionalOperator.create(transactionManager)));
      result = proxyFactory.getProxy();
    }
    return result;
  }

  
}
