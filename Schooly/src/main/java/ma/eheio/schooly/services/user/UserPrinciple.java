package ma.eheio.schooly.services.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import ma.eheio.schooly.model.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public class UserPrinciple implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;
    
	@SuppressWarnings("unused")
	private String userID;

	@SuppressWarnings("unused")
	private String firstName;
	
	@SuppressWarnings("unused")
	private String lastName;
	
	@SuppressWarnings("unused")
	private String phone;

	@SuppressWarnings("unused")
	private String email;
    
	private String username;

    @JsonIgnore
	private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrinciple(Long id, String userID, String firstName, String lastName, String phone, String email,
			String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new UserPrinciple(
                user.getId(),
                user.getUserID(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}