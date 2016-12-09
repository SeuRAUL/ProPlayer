package imd.player.control;

/**
 * The abstract representation of what parameters and responsibilities a user
 * should have.
 * @author Anderson Santos and Yuri Reinaldo
 */
public abstract class User {
    /**
     * A {@link String} that keeps the user id, this data should be hidden and
     * the user must not access it easily.
     */
    protected /*@ spec_public @*/ String id;
    /**
     * A {@link String} that keeps the user login, this should always be set when
     * creating a new User, since it is it's main key to access the data.
     */
    protected /*@ spec_public @*/ String login;
    /**
     * A {@link String} that keeps the user password, it must be set when creating
     * objects of this class and should not be easily accessed.
     */
    protected /*@ spec_public @*/ String password;
    
    /**
     * A simple constructor who sets the variables and creates a new id for the 
     * user.
     * @param login The login to be set.
     * @param password The password to be set.
     */
    /*@ 
      @ requires login != null;
      @ requires password != null;
      @ ensures this.login.equals(login);
      @ ensures this.password.equals(password);
      @*/
    public User(String login, String password){
        this.id = login.hashCode() + "";
        this.login = login;
        this.password = password;
    }

    /**
     * Returns the id of this User object, it is used in order to access data
     * related to this User.
     * @return a {@link String} representing this User's id. 
     */
    /*@	ensures \result == id; @*/
    public /*@ pure @*/ String getId() {
        return id;
    }

    /**
     * Returns the login of this User, this is mostly used to access other user's
     * objects.
     * @return a {@link String} with this user login. 
     */
    /*@	ensures \result == login; @*/
    public /*@ pure @*/ String getLogin() {
        return login;
    }

    /**
     * Returns this users password, should be used only for user verification
     * should be used sparingly.
     * @return 
     */
    /*@	ensures \result == password; @*/
    public /*@ pure @*/ String getPassword() {
        return password;
    }

    /**
     * Sets a new password to this user, used mostly for updating user data.
     * @param password this user's new password.
     */
    /*@ requires password != "";
	  @	ensures this.password.equals(password); @*/
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Turns this user data in a {@link String} in order to be saved in a backup.
     * @return A {@link String} that contains this user's login and password in
     * separate lines.
     */
    /*@ requires true;
	  @ assignable \nothing;
	  @ ensures \result == this.login + "\n" + this.password + "\n" @*/
    @Override
    public /*@ pure @*/ String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.login + "\n");
        sb.append(this.password + "\n");
        return sb.toString();
    }

}
