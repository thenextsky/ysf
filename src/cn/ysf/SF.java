package cn.ysf;
/**
 * 核心算法
 */
public class SF {
	private Param param;

	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}
	
	public void run() {
		Param param = new Param(10, 5, 1);
		Circle circle = new Circle();
		circle.init(param);
		while(circle.getAliveCount()>0) {//循环直到没人活着
			int count = 0;
			while(true) {
				Person person = circle.getCurrent();
				if(person.isAlive()) {//死过的不能参与报数
					count++;
					if(count==param.getM()) {//从k=1开始报数，到m=5删除
						circle.die(person);
						System.out.println("刪除了："+person);
						break;
					}
				}
			}
			System.out.println("此时状态：currentNumber:"+circle.getCurrentNumber());
		}
	}

	public static void main(String[] args) {
		new SF().run();
	}
	
}
