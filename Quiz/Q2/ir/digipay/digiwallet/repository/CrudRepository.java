package ir.digipay.digiwallet.repository;

import java.util.List;
import java.util.function.Predicate;

public interface CrudRepository<T, ID> {
    boolean add(T t);

    List<T> getAll();

    T get(ID id);

    List<T> get(Predicate<T> predicate);
}
