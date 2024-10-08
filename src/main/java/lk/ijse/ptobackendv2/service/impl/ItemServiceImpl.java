package lk.ijse.ptobackendv2.service.impl;

import lk.ijse.ptobackendv2.dao.ItemDao;
import lk.ijse.ptobackendv2.dto.impl.ItemDto;
import lk.ijse.ptobackendv2.entity.impl.ItemEntity;
import lk.ijse.ptobackendv2.exception.DataPersistException;
import lk.ijse.ptobackendv2.service.ItemService;
import lk.ijse.ptobackendv2.uill.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveItem(ItemDto itemDto) {
        ItemEntity save = itemDao.save(mapping.toItemEntity(itemDto));
        if (save == null) {
            throw new DataPersistException("Item not found");
        }
    }

    @Override
    public List<ItemDto> loadAllItems() {
        return mapping.toItemDtoList(itemDao.findAll());
    }
}
