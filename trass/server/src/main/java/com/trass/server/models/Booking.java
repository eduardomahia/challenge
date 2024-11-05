package com.trass.server.models;

public record Booking(String id, String type, String startTime, String endTime, String startPlaceName,
                      String startPlaceAddress, String placeCoordinates, String endPlaceName, String endPlaceAddress,
                      String endCoordinates, String suggestions, String price) {
}
