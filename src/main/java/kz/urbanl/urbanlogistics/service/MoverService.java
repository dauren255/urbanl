package kz.urbanl.urbanlogistics.service;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import kz.urbanl.urbanlogistics.model.Mover;

import java.util.List;

public interface MoverService {

    Mover updateMover(Mover mover, String username);

    List<Mover> getAllMovers(String username) throws InternalException;

    Mover createMover(Mover mover, String username) throws InternalException;

    void addMoverToCompany(Long companyId, Mover mover) throws InternalException;

}
