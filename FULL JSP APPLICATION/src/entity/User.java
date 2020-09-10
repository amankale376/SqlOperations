package entity;

public class User {
		private int userId;
		private String email;
		/**
		 * @param userId the userId to set
		 */
		public void setUserId(int userId) {
			this.userId = userId;
		}
		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		/**
		 * @return the userId
		 */
		public int getUserId() {
			return userId;
		}
		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}
		public User(int userId, String email) {
		
			this.userId = userId;
			this.email = email;
		}
		public User(String email) {
	
			this.email = email;
		}
		public User(int userId) {
		
			this.userId = userId;
		}
	
		
		
	
}
