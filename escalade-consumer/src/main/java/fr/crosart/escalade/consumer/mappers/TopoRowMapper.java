package fr.crosart.escalade.consumer.mappers;

import fr.crosart.escalade.model.beans.Topo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TopoRowMapper implements RowMapper<Topo> {

    @Override
    public Topo mapRow(ResultSet rs, int rownum) throws SQLException {

        Topo topo = new Topo();

        topo.setId(rs.getInt("topoid"));
        topo.setSiteId(rs.getInt("siteid"));
        topo.setUserId(rs.getInt("userid"));
        topo.setPending(rs.getBoolean("topoispending"));
        topo.setReserved(rs.getBoolean("topoisreserved"));
        topo.setReservedUserId(rs.getInt("reserveduserid"));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        topo.setPublishingDate(LocalDate.parse(rs.getString("topopublishingdate"), dateFormatter));
        LocalDate retrievedDate = LocalDate.parse(rs.getString("topopublishingdate"), dateFormatter);
        DateTimeFormatter dateFormatParser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        topo.setParsedPublishingDate(retrievedDate.format(dateFormatParser));

        return topo;

    }

}
