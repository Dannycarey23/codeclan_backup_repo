import WithLombok.EricsUser;
import WithoutLombok.User;

public class Runner {
    public static void main(String[] args) {
        User bigExampleUser = new User.builder("Spongebob","Roundpants")
                .address("2 PineApple grove, Bikini bottom, Nuclear Corner")
                .age(42)
                .build();
        System.out.println(bigExampleUser);

        EricsUser partyTrickUser = EricsUser
                .builder()
                .firstName("Spongebob")
                .lastName("RoundPants")
                .address("2 PineApple grove, Bikini bottom, Nuclear Corner")
                .age(42)
                .build();

        System.out.println(partyTrickUser);
    }
}
