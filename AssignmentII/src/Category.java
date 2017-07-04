/*
* List of categories available to items
*/
public enum Category {
    Antiques("Antiques"),
    Art("Art"),
    Baby("Baby"),
    BooksComicsMagazines("Books, Comics, & Magazines"),
    BusinessOfficeIndustrial("Business, Office, & Industrial"),
    CamerasPhotography("Cameras & Photography"),
    CarsMotorcyclesVehicles("Cars, Motorcycles, & Vehicles"),
    ClotheShoesAccessories("Clothes, Shoes, & Accessories"),
    Coins("Coins"),
    Collectables("Collectables"),
    ComputersTabletsNetworking("Computers, Tablets, & Networking"),
    Crafts("Crafts"),
    DollsBears("Dolls & Bears"),
    DVDsFilmsTV("DVDs, Films, & TV"),
    EventsTickets("Events Tickets"),
    GardenPatio("Garden & Patio"),
    HealthBeauty("Health & Beauty"),
    HolidaysTravel("Holidays & Travel"),
    HomeFurnitureDIY("Home, Furniture, & DIY"),
    JewelleryWatches("Jewellery & Watches"),
    MobilePhonesCommunication("Mobile Phones & Communication"),
    Music("Music"),
    MusicalInstruments("Musical Instruments"),
    PetSupplies("Pet Supplies"),
    PotteryPorcelainGlass("Pottery, Poreclain, & Glass"),
    Property("Property"),
    SoundVision("Sound & Vision"),
    SportingGoods("Sporting Goods"),
    SportsMemorabilia("Sports Memorabilia"),
    Stamps("Stamps"),
    ToysGames("Toys & Games"),
    VehiclePartsAccessories("Vehicles Parts & Accessories"),
    VideoGamesConsoles("Video Games & Consoles"),
    WholesaleJobLots("Wholesale Job Lots"),
    EverythingElse("Everything Else");

    private final String text;

    Category(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
