package be.vdab.allesvoordekeuken.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql("/insertArtikel.sql")
@Import(JpaArtikelRepository.class)
public class JpaArtikelRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private final JpaArtikelRepository repository;

    public JpaArtikelRepositoryTest(JpaArtikelRepository repository) {
        this.repository = repository;
    }
    private long nummerVanTestArtikel(){
        return super.jdbcTemplate.queryForObject("select id from artikels where naam = 'testNaam'",Long.class);
    }
    @Test
    void findByNummer(){
        assertThat(repository.findByNummer(nummerVanTestArtikel()).get().getNaam()).isEqualTo("testNaam");
    }
    @Test
    void findByOnbestaandeNummer(){
        assertThat(repository.findByNummer(-1)).isNotPresent();
    }
}
