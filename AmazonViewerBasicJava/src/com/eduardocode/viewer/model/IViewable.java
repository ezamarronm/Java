package com.eduardocode.viewer.model;

import java.util.Date;

public interface IViewable {
	Date startToSee(Date dateI);
	void stopToSee(Date dateI,Date dateF);
}
