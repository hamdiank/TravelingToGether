package tn.cynapsys.services;



import java.util.List;

import tn.cynapsys.entities.Train;


public interface TrainService {
	
public List<Train> listTrain();
	
	public Train getTrain(Long id);
	
	public Train saveTrain(Train t);
	
	public Train update ( Train a , Long id);
	
	public void delete(Long id );

}
