public static void searchID() throws ClassNotFoundException{
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	Class.forName(DRIVER_NAME);
	
	try{
		conn = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from Product where Id=1");
		
		System.out.println("ProductName: " + rs.getString("ProductName"));
		System.out.println("Inventory: " + rs.getInt("Inventory"));
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		try{
			if(conn != null)
				conn.close();
			if(stmt != null)
				stmt.close();
			if(rs != null)
				rs.close();			
	}catch(SQLException e){
		//ignore
	}
	}
}