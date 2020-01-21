package be.vdab.allesvoordekeuken.repositories;

import be.vdab.allesvoordekeuken.domain.Artikel;

import java.util.List;
import java.util.Optional;

public interface ArtikelRepository {
    Optional<Artikel> findByNummer(long id);
    void create(Artikel artikel);
    List<Artikel> findByNaamContains(String woord);
}
