package com.station.pesistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.metrosystem.helper.MySQLConnection;

public class StationDaoImpl implements StationDao {
	@Override
	public boolean addStation(int id, String stationName) throws ClassNotFoundException, SQLException {
		Connection connection=MySQLConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into stations values(null, ?);");
		statement.setString(1, stationName);
		int rows = statement.executeUpdate();
//		Station name = new Station(id, stationName);
//		Stations.getStations().put(name.getId(), name);
		if(rows>0){
			connection.close();
			return true;
		}
		connection.close();
		return true;
	}
}
