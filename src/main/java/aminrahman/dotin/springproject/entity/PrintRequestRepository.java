package aminrahman.dotin.springproject.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
@Transactional
public class PrintRequestRepository implements JpaRepository<PrintRequest, PrintPK> {

    Logger logger = LoggerFactory.getLogger(PrintRequestRepository.class);

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<PrintRequest> findAll() {
        return null;
    }

    @Override
    public List<PrintRequest> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PrintRequest> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<PrintRequest> findAllById(Iterable<PrintPK> printPKS) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(PrintPK printPK) {

    }

    @Override
    public void delete(PrintRequest entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends PrintPK> printPKS) {

    }

    @Override
    public void deleteAll(Iterable<? extends PrintRequest> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends PrintRequest> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PrintRequest> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PrintRequest> findById(PrintPK printPK) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(PrintPK printPK) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends PrintRequest> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends PrintRequest> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<PrintRequest> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<PrintPK> printPKS) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PrintRequest getOne(PrintPK printPK) {
        return null;
    }

    @Override
    public PrintRequest getById(PrintPK printPK) {
        return null;
    }

    @Override
    public PrintRequest getReferenceById(PrintPK printPK) {
        return null;
    }

    @Override
    public <S extends PrintRequest> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PrintRequest> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PrintRequest> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PrintRequest> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PrintRequest> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PrintRequest> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends PrintRequest, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
