public enum Genre {
    CHILDRENS("You know, for kids"),
    HORROR("You know, not for kids"),
    SCIFI("You know, for big kids");

    private final String description;

    Genre(String description) {this.description = description;}

    public String getDescription() {return this.description;}



}
