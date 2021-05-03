package kz.urbanl.urbanlogistics.service.impl;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import kz.urbanl.urbanlogistics.model.Order;
import kz.urbanl.urbanlogistics.model.Photo;
import kz.urbanl.urbanlogistics.model.PhotoDetails;
import kz.urbanl.urbanlogistics.repository.PhotoDetailsRepo;
import kz.urbanl.urbanlogistics.repository.PhotoRepo;
import kz.urbanl.urbanlogistics.service.PhotoDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoDetailsServiceImpl implements PhotoDetailsService {

    @Autowired
    private PhotoDetailsRepo photoDetailsRepo;

    @Autowired
    private PhotoRepo photoRepo;

    @Override
    public void createPhotoDetails(PhotoDetails photoDetails) throws InternalException {
        photoDetailsRepo.saveAndFlush(photoDetails);
    }

    @Override
    public List<PhotoDetails> getAllPhotoDetails() throws InternalException {
        return photoDetailsRepo.findAll();
    }

    @Override
    public PhotoDetails getPhotoDetailsById(Long photoDetailsId) throws InternalException {
        return photoDetailsRepo.findById(photoDetailsId).get();
    }

    @Override
    public PhotoDetails updatePhotoDetails(PhotoDetails photoDetails) throws InternalException {
        PhotoDetails updatePhotoDetails = photoDetailsRepo.findById(photoDetails.getId()).get();
        return photoDetailsRepo.saveAndFlush(updatePhotoDetails);
    }

    @Override
    public void addPhotoDetailsToPhoto(Long id, PhotoDetails photoDetails) {
        Photo photo = photoRepo.findById(id).get();
        photo.getPhotoDetails().add(photoDetails);
    }

    @Override
    public void deletePhotoDetails(PhotoDetails photoDetails) throws InternalException {
        photoDetailsRepo.delete(photoDetails);
    }
}
