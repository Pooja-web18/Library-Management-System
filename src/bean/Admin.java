package bean;

public class Admin {

        private int Id;
        private String Name;
        private String Email;
        private String Password;

        public Admin() {
            super();
        }



        public Admin(int aId, String aName, String aEmail, String aPassword) {
            super();
            this.Id = aId;
            this.Name = aName;
            this.Email = aEmail;
            this.Password = aPassword;
        }



        public int getaId() {
            return Id;
        }

        public void setaId(int Id) {
            this.Id = Id;
        }



        public String getaName() {
            return Name;
        }



        public void setaName(String Name) {
            this.Name = Name;
        }



        public String getaEmail() {
            return Email;
        }

        public void setaEmail(String Email) {
            this.Email = Email;
        }

        public String getaPassword() {
            return Password;
        }

        public void setaPassword(String Password) {
            this.Password = Password;
        }



        @Override
        public String toString() {
            return "Admin [Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", Password=" + Password + "]";
        }
}

