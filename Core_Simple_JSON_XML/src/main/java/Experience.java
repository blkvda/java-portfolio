public class Experience {
    private String companyName;
    private String position;
    private int ageOfExperience;

    public Experience() {}

    public Experience(String companyName, String position, int ageOfExperience) {
        this.companyName = companyName;
        this.position = position;
        this.ageOfExperience = ageOfExperience;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAgeOfExperience() {
        return ageOfExperience;
    }

    public void setAgeOfExperience(int ageOfExperience) {
        this.ageOfExperience = ageOfExperience;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", ageOfExperience=" + ageOfExperience +
                '}';
    }
}
