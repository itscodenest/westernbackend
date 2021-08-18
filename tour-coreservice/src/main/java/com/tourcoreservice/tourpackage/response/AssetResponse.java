package com.tourcoreservice.tourpackage.response;

import com.tourcoreservice.generic.pojo.AbstractPojoResponse;
import com.tourcoreservice.tourpackage.pojo.AssetPojo;

public class AssetResponse extends AbstractPojoResponse{

	AssetPojo assetPojo;

	public AssetPojo getAssetPojo() {
		return assetPojo;
	}

	public void setAssetPojo(AssetPojo assetPojo) {
		this.assetPojo = assetPojo;
	}
}
