package lasermaze.model.user;

import java.util.Objects;

public class User {
    public static final User DUMMY_USER = new DummyUser();

    private String name;

    public User(String name) {
        this.name = name;
    }

    boolean isDummyUser() {
        return false;
    }

    private static class DummyUser extends User {
        private static final String DUMMY_NAME = "DUMMY";

        public DummyUser() {
            super(DUMMY_NAME);
        }

        @Override
        boolean isDummyUser() {
            return true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }
}
