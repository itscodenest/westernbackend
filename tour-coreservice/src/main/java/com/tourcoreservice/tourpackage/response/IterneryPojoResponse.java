package com.tourcoreservice.tourpackage.response;

import com.tourcoreservice.generic.pojo.AbstractPojoResponse;
import com.tourcoreservice.tourpackage.pojo.IterneryPojo;

public class IterneryPojoResponse  extends AbstractPojoResponse{
	public IterneryPojo iterneryPojo;

	public IterneryPojo getIterneryPojo() {
		return iterneryPojo;
	}

	public void setIterneryPojo(IterneryPojo iterneryPojo) {
		this.iterneryPojo = iterneryPojo;
	}

}