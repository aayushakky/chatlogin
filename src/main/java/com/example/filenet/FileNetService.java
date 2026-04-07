//package com.example.filenet;
//
//import javax.security.auth.Subject;
//
//import com.filenet.api.collection.RepositoryRowSet;
//import com.filenet.api.core.Connection;
//import com.filenet.api.core.Domain;
//import com.filenet.api.core.Factory;
//import com.filenet.api.core.ObjectStore;
//import com.filenet.api.query.RepositoryRow;
//import com.filenet.api.query.SearchSQL;
//import com.filenet.api.query.SearchScope;
//import com.filenet.api.util.UserContext;
//
//public class FileNetService {
//
//    private final String uri = "http://192.168.1.20:9080/wsi/FNCEWS40MTOM/";
//
//    // ✅ Step 1: Connection Method (existing)
//    public Connection connect(String username, String password) {
//
//        try {
//            Connection conn = Factory.Connection.getConnection(uri);
//
//            Subject subject = UserContext.createSubject(
//                    conn,
//                    username,
//                    password,
//                    "FileNetP8WSI"
//            );
//
//            UserContext.get().pushSubject(subject);
//
//            System.out.println("✅ Connected to FileNet!");
//
//            return conn;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("FileNet connection failed: " + e.getMessage());
//        }
//    }
//
//    // ✅ Step 2: Fetch Object Store
//    public ObjectStore getObjectStore(Connection conn) {
//
//        try {
//            Domain domain = Factory.Domain.fetchInstance(conn, null, null);
//
//            // 🔥 IMPORTANT: Replace with your actual Object Store name
//            String objectStoreName = "DSO1";
//
//            ObjectStore os = Factory.ObjectStore.fetchInstance(
//                    domain,
//                    objectStoreName,
//                    null
//            );
//
//            System.out.println("✅ Connected to Object Store: " + objectStoreName);
//
//            return os;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to fetch ObjectStore: " + e.getMessage());
//        }
//    }
//
//    // ✅ Step 3: Fetch Documents
//    public String fetchDocuments(String username, String password) {
//
//        StringBuilder result = new StringBuilder();
//
//        try {
//            // 🔗 Connect
//            Connection conn = connect(username, password);
//
//            // 📂 Get Object Store
//            ObjectStore os = getObjectStore(conn);
//
//            // 🔍 Query
//            String query = "SELECT DocumentTitle FROM Document";
//
//            SearchSQL sql = new SearchSQL(query);
//            SearchScope scope = new SearchScope(os);
//
//            RepositoryRowSet rows = scope.fetchRows(sql, null, null, Boolean.TRUE);
//
//            // 📄 Loop through results
//            java.util.Iterator<?> iterator = rows.iterator();
//
//            while (iterator.hasNext()) {
//
//                RepositoryRow row = (RepositoryRow) iterator.next();
//
//                String docName = row.getProperties().getStringValue("DocumentTitle");
//
//                result.append(docName).append("\n");
//            }
//            System.out.println("✅ Documents fetched successfully!");
//
//            return result.toString();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "❌ Error fetching documents: " + e.getMessage();
//        }
//    }
//}





//package com.example.filenet;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class FileNetService {
//
//    public boolean establishConnection(String uri, String username, String password, String stanza) {
//        try {
//            System.out.println("Connecting to FileNet...");
//            System.out.println("User: " + username);
//
//            // 🔥 Replace with actual FileNet connection logic
//            if (username != null && !username.isEmpty() &&
//                password != null && !password.isEmpty()) {
//                return true;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//}