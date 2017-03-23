package ru.inbox.savinov_vu.service;

import java.util.List;

public interface ParentService<T> {

    List<T> getAll();
}
