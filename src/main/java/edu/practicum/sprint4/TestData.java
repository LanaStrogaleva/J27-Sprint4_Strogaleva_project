package edu.practicum.sprint4;

public class TestData {
    public String name;
    public String surname;
    public String address;
    public String station;
    public String phoneNumber;
    public String comment;

    TestData(
            String testDateName,
            String testDateSurname,
            String testDateAddress,
            String testDateStation,
            String testDatePhoneNumber,
            String testDateComment
    ) {
        name = testDateName;
        surname = testDateSurname;
        address = testDateAddress;
        station = testDateStation;
        phoneNumber = testDatePhoneNumber;
        comment = testDateComment;

    }

}
