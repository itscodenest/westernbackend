package com.tourcoreservice.tourpackage.response;

import java.util.List;

import com.tourcoreservice.generic.pojo.AbstractPojoResponse;
import com.tourcoreservice.tourpackage.pojo.IterneryPojo;

public class IterneryPojoListResponse  extends AbstractPojoResponse{
	public List<IterneryPojo> iterneryListPojo;

	public List<IterneryPojo> getIterneryListPojo() {
		return iterneryListPojo;
	}

	public void setIterneryListPojo(List<IterneryPojo> iterneryListPojo) {
		this.iterneryListPojo = iterneryListPojo;
	}

}
