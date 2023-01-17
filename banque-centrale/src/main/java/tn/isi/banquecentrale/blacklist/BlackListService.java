package tn.isi.banquecentrale.blacklist;

import java.util.Map;

public interface BlackListService {

    Map<String, Boolean> isBlackList(String cin);
}
