package cn.ysf;
/**
 * 核心算法
 */
public class SF {
	private Param param = new Param(20, 5, 1);
	private int speed = 0;
	public static final int status_stop = 0;
	public static final int status_running = 1;
	public static final int status_pause = 2;
	private int status = status_stop;
	private Circle circle = null;
	private Thread thread = null;
	public static StringBuilder result = new StringBuilder();
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public SF(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}
	
	public void run() {
		if(thread==null) {
			thread = new Thread(new Runnable() {
				public void run() {
					status = SF.status_running;
					circle = new Circle();
					circle.init(param);
					result.setLength(0);
					while(circle.getAliveCount()>0) {//循环直到没人活着
						if(status==SF.status_stop) {
							return;
						}
						if(status==SF.status_pause) {
							try {
								Thread.sleep(300);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							continue;
						}
						int count = 0;
						while(true) {
							if(status==SF.status_stop) {
								return;
							}
							if(status==SF.status_pause) {
								try {
									Thread.sleep(300);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								continue;
							}
							Person person = circle.getCurrent();
							if(person.isAlive()) {//死过的不能参与报数
								count++;
								System.out.println("报数："+count);
								if(count==param.getM()) {//从k=1开始报数，到m=5删除
									circle.die(person);
									System.out.println("刪除了："+person);
									result.append(person.getNumber()+"出列\r\n");
									sleep();
									break;
								}
								sleep();
							}
						}
						System.out.println("currentNumber:"+circle.getCurrentNumber());
					}
					SF.this.setStatus(SF.status_stop);
				}
			});
			thread.start();
		}else {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			thread = null;
			this.run();
		}
	}
	
	private void sleep() {
		try {
			if(speed<0) {
				speed = 0;
			}
			if(speed>100) {
				speed = 100;
			}
			Thread.sleep(2000-speed*20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
