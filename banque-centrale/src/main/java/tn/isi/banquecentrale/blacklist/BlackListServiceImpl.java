package tn.isi.banquecentrale.blacklist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlackListServiceImpl implements BlackListService {

    private final BlackListRepository blackListRepository;

    @Override
    public Map<String, Boolean> isBlackList(String cin) {
        Map<String, Boolean> response = new HashMap<>();
        Optional<BlackList> blackListOptional = blackListRepository.findById(cin);
        if (blackListOptional.isEmpty()) {
            response.put("isBlackListed", false);
            return response;
        }
        response.put("isBlackListed", blackListOptional.get().getIsBlackList());
        return response;
    }
}
