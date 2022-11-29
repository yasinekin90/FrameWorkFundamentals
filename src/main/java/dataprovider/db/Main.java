package dataprovider.db;

public class Main {

    public static void main(String[] args) {
        DBUtility db = new DBUtility("jdbc:mysql://localhost:3306/sakila","root", "");
        String sql1 = "SELECT first_name,last_name,address FROM actor " +
                "LEFT JOIN address ON actor.actor_id=address.address_id LIMIT 10;";

        db.getDataWithHeaders(sql1);

        db.close();
    }

}
