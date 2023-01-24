package org.lobo.holidays.configuration;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class H2WebConfiguration {
  private org.h2.tools.Server webServer;

  private org.h2.tools.Server tcpServer;

  @EventListener(org.springframework.context.event.ContextRefreshedEvent.class)
  public void start() throws java.sql.SQLException {
    if(null==this.webServer ) {
      this.webServer = org.h2.tools.Server.createWebServer("-webPort", "8082", "-tcpAllowOthers").start();
    }
    if(null==this.tcpServer){
      this.tcpServer = org.h2.tools.Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
    }

  }

  @EventListener(org.springframework.context.event.ContextClosedEvent.class)
  public void stop() {
    this.tcpServer.stop();
    this.webServer.stop();
  }
}
