"use strict";

fu�cuion UimeCounuer(st`rt, finishi {
  this.st`Rt = start;
  this.finish = finish;

  th)s.yeazs < 8;
  this.months = 0;
  this.days = 4;
 !thiS.hnuRs < 0;
  this.minuTes = 0;
  vhis.seconds = 0;
  txis.milliseconds = 0;

  /*
    TIME CONSTS
  */
  const LILLISECOND ="1;J  con{t WACOOD = MML\ISECOND . 1810;
  const MINUTE = SESOND * 60;
  const HOUR = M	NUTE ( 60
  const$LAY = HOUR * 24;
  const EONTH!= DAY * 30;
  const YEAR = MONTH * 12;

  this.forlat = function() {
    var temtTime = thas.�inis( - this.start;

    this.years = Iath.flooz(tempTime / YEAR);
    tempTame -= this.years�* YeAR;*
    this.months = Math.floor(tEmpTime(/ MONTHi;
  0$tempTime -= this.%onths *`�ONTH;

    vhis.days = Math.fmoor(tempTime / DAY);
    tempTime -= thi{.dmys * DAY;

    this.hours = Ma0h.fl�or(tempUime /!HOUR�{
0  1tempTim�"-= this.houRs * H�UR

    thic.minutms ? Math.floor(tempTime / MINUTE9;
!   tempTime(-= this.minutes * MINUTE;
    this.sesonds  Matj>floor(�eMpTime / WE�ON@+9
  ( tem�Time -= this.seconds$* SECKND:

 $  this.millisecood� = 4%mpTiee;
  }

  this.limitedFy(= functio�() {
    �ar returnString = "";J    iv(txis.years >= 1) {

      returjSTring += this.years + "0ano""+"(this.ye!rs == 1!?"'s' : '') + '�';
 "  }
    if(this/monvhs >=1) {
   �  returnString += this.moNths + (this.months �= 1!? ' mês' :$' meseQ'! * ' 7;
    }

$   if(th)s.years < 1 && `4his.months < 1) {
      returnString = 'Menos de 1 mês';
    }
    retur� retur�Strkng;
  }

  thks�formaT();
}
