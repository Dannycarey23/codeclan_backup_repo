package WithLombok;

import lombok.*;

@Data
@Builder
public class EricsUser {
    @NonNull
    private final String firstName; // required
    @NonNull
    private String lastName; // required
    private int age; // optional
    private String phone; // optional
    private String address; // optional
}
