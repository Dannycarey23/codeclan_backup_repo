public class Person {

    private String name;
    private String cohort;

    public Person(String name, String cohort) {
        this.name = name;
        this.cohort = cohort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }

    public String talk(String favLanguage){
        return String.format("I love %s!", favLanguage);
    }
}

