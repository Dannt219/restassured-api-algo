package model;

import io.restassured.http.Header;

public interface HeaderCapability {
    Header defaultHeader = new Header("Content-type", "application/json; charset=UTF-8");
}
