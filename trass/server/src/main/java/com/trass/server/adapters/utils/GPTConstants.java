package com.trass.server.adapters.utils;

public final class GPTConstants {
    public enum Models {
        GPT3_5("gpt-3.5-turbo"),
        GPT4("gpt-4");
        Models(String value) {
            this.value = value;
        }
        public final String value;
    }

    public enum ResponseFormat {
        JSON("json_object"),
        TEXT("text");
        ResponseFormat(String value) {
            this.value = value;
        }
        public final String value;
    }

    public enum MessageType {
        SYSTEM("system"),
        USER("user");
        MessageType(String value) {
            this.value = value;
        }
        public final String value;
    }

    public static final String GET_BOOKING_DETAILS_PROMPT_MESSAGE = "You will be provided with a text by quotes. " +
            "Classify it by type: flight, accommodation, rental, event or appointment and " +
            "return the following info in json format depending on the category\n" +
            "flight\n" +
            "- bookingType\n" +
            "- bookingId\n" +
            "- List of flights in the booking as 'flights' with the following data:\n" +
            " - departure\n" +
            " - departureTime in format 'YYYY/mm/dd HH:mm:ss'\n" +
            " - arrival\n" +
            " - arrivalTime in format 'YYYY/mm/dd HH:mm:ss'\n" +
            " - flightNumber\n" +
            " - airline\n\n" +
            "accommodation\n" +
            "- bookingType\n" +
            "- bookingId\n" +
            "- location\n" +
            "- checkInDate in format 'YYYY/mm/dd HH:mm:ss'\n" +
            "- checkOutDate in format 'YYYY/mm/dd HH:mm:ss'\n\n" +
            "rental\n" +
            "- bookingType\n" +
            "- bookingId\n" +
            "- pickUpLocation\n" +
            "- pickUpDate in format 'YYYY/mm/dd HH:mm:ss'\n" +
            "- dropOffLocation\n" +
            "- dropOffDate in format 'YYYY/mm/dd HH:mm:ss'\n" +
            "event\n" +
            "- bookingType\n" +
            "- bookingId\n" +
            "- location\n" +
            "- date in format 'YYYY/mm/dd HH:mm:ss'\n\n" +
            "appointment\n" +
            "- bookingType\n" +
            "- bookingId\n" +
            "- location\n" +
            "- date in format 'YYYY/mm/dd HH:mm:ss'\n" +
            "Otherwise return unknown";

    public static final int TEMPERATURE_LEVEL_REALISTIC = 0;
}
