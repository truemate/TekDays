package com.tekdays

class TekEvent {

    String city
    String name
    TekUser organizer
    String venue
    Date startDate
    Date endDate
    String description

    static constraints = {
        name()
        city()
        description maxSize: 5000
        organizer()
        venue()
        startDate()
        endDate()
        volunteers nullable: true
        sponsorships nullable: true
        tasks nullable: true
        messages nullable: true
    }
    static searchable = true
    static hasMany = [volunteers  : TekUser,
                      responders  : String,
                      sponsorships: Sponsorship,
                      tasks       : Task,
                      messages    : TekMessage]

    @Override
    public String toString() {
        return "$name, $city";
    }
}
