package kz.urbanl.urbanlogistics.service;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import kz.urbanl.urbanlogistics.model.Photo;
import kz.urbanl.urbanlogistics.model.PhotoDetails;

import java.util.List;

public interface PhotoDetailsService {
    void createPhotoDetails(PhotoDetails photoDetails) throws InternalException;

    List<PhotoDetails> getAllPhotoDetails() throws InternalException;

    PhotoDetails getPhotoDetailsById(Long photoDetailsId) throws InternalException;

    PhotoDetails updatePhotoDetails(PhotoDetails photoDetails) throws InternalException;

    void addPhotoDetailsToPhoto(Long id, PhotoDetails photoDetails);

    void deletePhotoDetails(PhotoDetails photoDetails) throws InternalException;
}
