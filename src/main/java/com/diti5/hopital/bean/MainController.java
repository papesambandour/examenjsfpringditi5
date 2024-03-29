package com.diti5.hopital.bean;


import com.diti5.hopital.dao.ServiceDOA;
import com.diti5.hopital.model.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class MainController {
  @Autowired
  private ServiceDOA serviceDOA;
  private Service service ;
  private List<Service> services ;
  @PostConstruct
  public void init(){
    service = new Service();
    services = serviceDOA.findAll();

  }

  public String saveService(){
    try {
      System.out.println(service.getLibelle());
      serviceDOA.save(service);
      return "/page/index?faces-redirect=true&succes=true";
    }catch (Exception e)
    {
      System.out.println(e.getMessage());
      return "/page/index?faces-redirect=true&error=true";
    }
  }

  public Service getService() {
    return service;
  }

  public void setService(Service service) {
    this.service = service;
  }

  public List<Service> getServices() {
    return services;
  }

  public void setServices(List<Service> services) {
    this.services = services;
  }
}
