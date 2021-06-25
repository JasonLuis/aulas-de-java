package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.SegmentoModel;

@Repository
public interface SegmentRepository extends JpaRepository<SegmentoModel, Long>{

}
