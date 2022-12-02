package com.freyvik.springboot_testing.rest.app.usuario.dataExample;

import com.freyvik.springboot_testing.rest.app.usuario.models.Address;
import com.freyvik.springboot_testing.rest.app.usuario.models.AddressType;
import com.freyvik.springboot_testing.rest.app.usuario.models.User;

public class Data {

    public static AddressType ADDRESSTYPE = AddressType.builder().id(1L).type("calle").description("Calle normal").build();
    public static Address ADDRESS = Address.builder().id(1L).name("Invented").addressType(ADDRESSTYPE).build();
    public static User USER = User.builder().id(1L).name("FreyVik").address(ADDRESS).build();
}
