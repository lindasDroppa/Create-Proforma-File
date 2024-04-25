package com.example.filescreate;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SkynetQouteRequest
{
    @JsonProperty("SecurityToken")
    public String securityToken;
    @JsonProperty("AccountNumber")
    public String accountNumber;
    @JsonProperty("FromCity")
    public String fromCity;
    @JsonProperty("FromCityPostalCode")
    public String fromCityPostalCode;
    @JsonProperty("ToCity")
    public String toCity;
    @JsonProperty("ToCityPostalCode")
    public String toCityPostalCode;
    @JsonProperty("ServiceType")
    public String serviceType;
    @JsonProperty("InsuranceType")
    public String insuranceType;
    @JsonProperty("InsuranceAmount")
    public String insuranceAmount;
    @JsonProperty("DestinationPCode")
    public String destinationPCode;

    @JsonProperty("ParcelList")
    public List<ParcelDims> parcelList;
}
