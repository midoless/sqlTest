public static void dbpoolInit(){
	ds = new BasicDataSource();
	ds.setUrl(DB_URL);
	ds.setDriverClassName(DRIVER_NAME);
	ds.setUsername(DB_USER_NAME);
	ds.setPassword(DB_PASSWORD);
}

public void dbPoolTest(){
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try{
		conn = ds.getConnection();
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