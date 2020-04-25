package com.guojc.bean.lookUp;

public abstract class GetBeanTest {
    public void showMe(){
       this.getBean().showMe();
    }

    public abstract User getBean();
}
