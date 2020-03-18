package fr.crosart.escalade.consumer.mappers;

import fr.crosart.escalade.model.beans.Topo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TopoListRowMapper implements RowMapper<Topo> {

    @Override
    public Topo mapRow(ResultSet rs, int rownum) throws SQLException {

        Topo topo = new Topo();

        topo.setId(rs.getInt("topoid"));
        topo.setSiteId(rs.getInt("siteid"));
        topo.setUserId(rs.getInt("userid"));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        topo.setPublishingDate(LocalDate.parse(rs.getString("topopublishingdate"), dateFormatter));
        topo.setReserved(rs.getBoolean("topoisreserved"));
        topo.setReservedUserId(rs.getInt("reserveduserid"));
        topo.setReservedUserName(rs.getString("usernickname"));
        topo.setSiteName(rs.getString("sitename"));
        topo.setSiteDepartment(rs.getString("sitedepartment"));

        return topo;

    }

}
