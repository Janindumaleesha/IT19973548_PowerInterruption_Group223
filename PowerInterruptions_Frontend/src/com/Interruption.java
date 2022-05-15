package com;

import java.sql.*;

public class Interruption {
	
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electrogrid","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public String readInterruptions() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table width=100%;><tr><th>Date</th><th>Time Slot</th><th>LocationID</th><th>Area</th>"
					+ "<th>Reason</th><th>Status</th><th>Update</th><th>Remove</th></tr>";
			String query = "select * from interruption";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String interruptionID = Integer.toString(rs.getInt("interruptionID"));
				String date = rs.getString("date");
				String timeSlot = rs.getString("timeSlot");
				String locationID = rs.getString("locationID");
				String area = rs.getString("area");
				String reason = rs.getString("reason");
				String status = rs.getString("status");
				// Add into the html table
				output += "<tr><td><input id='hidInterruptionIDUpdate' name='hidInterruptionIDUpdate' type='hidden' value='" + interruptionID
						+ "'>" + date + "</td>";
				output += "<td>" + timeSlot + "</td>";
				output += "<td>" + locationID + "</td>";
				output += "<td>" + area + "</td>";
				output += "<td>" + reason + "</td>";
				output += "<td>" + status + "</td>";
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-interruptionid='"
						+ interruptionID + "'>" + "</td></tr>";
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the interruptions.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String insertInterruption(String dat, String timeslot, String locationid, String are, String reaso, String statu) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into interruption(`interruptionID`,`date`,`timeSlot`,`locationID`,`area`,`reason`,`status`)"

					+ " values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, dat);
			preparedStmt.setString(3, timeslot);
			preparedStmt.setString(4, locationid);
			preparedStmt.setString(5, are);
			preparedStmt.setString(6, reaso);
			preparedStmt.setString(7, statu);
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newInterruptions = readInterruptions();
			output = "{\"status\":\"success\", \"data\": \"" + newInterruptions + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while inserting the interruption.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String updateInterruption(String ID, String dat, String timeslot, String locationid, String are, String reaso, String statu) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE interruption SET date=?,timeSlot=?,locationID=?,area=?,reason=?,status=? WHERE interruptionID="+ID;
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, dat);
			preparedStmt.setString(2, timeslot);
			preparedStmt.setString(3, locationid);
			preparedStmt.setString(4, are);
			preparedStmt.setString(5, reaso);
			preparedStmt.setString(6, statu);
			preparedStmt.setInt(7, Integer.parseInt(ID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newInterruptions = readInterruptions();
			output = "{\"status\":\"success\", \"data\": \"" + newInterruptions + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while updating the interruption.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String deleteInterruption(String interruptionID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from interruption where interruptionID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(interruptionID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newInterruptions = readInterruptions();
			output = "{\"status\":\"success\", \"data\": \"" + newInterruptions + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while deleting the interruption.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
