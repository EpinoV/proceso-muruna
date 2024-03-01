package cl.muruna.epv.procesomuruna.mappers;

import cl.muruna.epv.procesomuruna.dto.PhoneDTO;
import cl.muruna.epv.procesomuruna.model.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class PhoneMapper {
    public static final PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "cityCode", source = "phoneNumber")
    @Mapping(target = "countryCode", source = "phoneNumber")
    public abstract PhoneDTO entityToDTO(Phone entity);

    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "cityCode", source = "phoneNumber")
    @Mapping(target = "countryCode", source = "phoneNumber")
    public abstract Phone dtoToEntity(PhoneDTO dto);

    public abstract List<PhoneDTO> entityListToDTOList(List<Phone> entityList);

    public abstract List<Phone> dtoListToEntityList(List<PhoneDTO> dtoList);

}
