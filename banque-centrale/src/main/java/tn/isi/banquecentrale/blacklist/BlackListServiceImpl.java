package tn.isi.banquecentrale.blacklist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlackListServiceImpl implements BlackListService {

    private final BlackListRepository blackListRepository;

    @Override
    public Boolean isBlackList(String cin) {
        return blackListRepository.getById(cin).getIsBlackList();
    }
}
